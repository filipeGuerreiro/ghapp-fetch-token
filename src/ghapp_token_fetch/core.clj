(ns ghapp-token-fetch.core
  (:require [cli-matic.core :refer [run-cmd]]
            [tentacles.core :refer [api-call url]]
            [buddy.core.keys :refer [private-key]]
            [buddy.sign.jwt :refer [sign]]
            [clj-time.core :as t]
            [clj-time.coerce :as c])
  (:gen-class))

(defn- gen-jwt [app-id pkey-file-path]
  (let [pkey    (private-key pkey-file-path)
        parse-time #(long (/ (c/to-long %) 1000))
        payload {:iat (parse-time (t/now))
                 :exp (parse-time (t/plus (t/now) (t/minutes 10)))
                 :iss app-id}]
    (sign payload pkey {:alg :rs256})))

(defn- fetch-token [{:keys [endpoint app-id installation-id pkey-file-path]}]
  (let [jwt     (gen-jwt app-id pkey-file-path)
        options {:oauth-token (str "Bearer " jwt)
                 :accept "application/vnd.github.v3+json"}]
    (binding [url endpoint]
      (println 
       (:message (:body (api-call :get "app/installations/%s/access_tokens" [installation-id] options)))))))

(def CLI_CONFIG
  {:command     "ghapp-token-fetch"
   :runs        fetch-token
   :opts        [{:as "Github API endpoint"
                  :option "endpoint" :short "e"
                  :default "https://api.github.com/"
                  :type :string}
                 {:as     "App ID"
                  :option "app-id" :short "a"
                  :type   :int}
                 {:as      "Installation ID"
                  :option  "installation-id" :short "i"
                  :type    :int}
                 {:as      "Path to private key file"
                  :option  "pkey-file-path" :short "k"
                  :type    :string}]})

(defn -main [& args]
  (run-cmd args CLI_CONFIG))
