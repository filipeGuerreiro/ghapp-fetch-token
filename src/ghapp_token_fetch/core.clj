(ns ghapp-token-fetch.core
  (:require [cli-matic.core  :refer [run-cmd]]
            [tentacles.core  :refer [api-call with-url with-defaults]]
            [buddy.core.keys :refer [private-key]]
            [buddy.sign.jwt  :refer [sign]]
            [clj-time.core   :as t]
            [clj-time.coerce :as c])
  (:gen-class))

(defn- joda->i [t] (long (/ (c/to-long t) 1000)))
(defn- gen-jwt [app-id pkey-file-path]
  (let [pkey    (private-key pkey-file-path)
        payload {:iat (joda->i (t/now))
                 :exp (joda->i (t/plus (t/now) (t/minutes 10)))
                 :iss app-id}]
    (sign payload pkey {:alg :rs512})))

(defn- fetch-token [{:keys [endpoint app-id installation-id pkey-file-path]}]
  (let [jwt (gen-jwt app-id pkey-file-path)
        res (with-url endpoint
              (with-defaults {:accept "application/vnd.github.v3+json"
                              :headers {"Authorization" (str "Bearer " jwt)}}
                (api-call :get "app/installations/%s/access_tokens" [installation-id])))]
      (println (-> res :body :message))))

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
