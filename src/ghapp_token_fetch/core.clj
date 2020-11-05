(ns ghapp-token-fetch.core
  (:require [cli-matic.core :refer [run-cmd]]
            [tentacles.core :refer [api-call]]
            [buddy.core.keys :refer [private-key]]
            [buddy.sign.jwt :refer [sign]]
            [clj-time.core :as time])
  (:gen-class))

(defn gen-jwt [app-id pkey-file-path]
  (let [pkey    (private-key pkey-file-path)
        payload {:iat time/now
                 :exp (time/plus (time/now) (time/minutes 10))
                 :iss app-id}]
    (sign payload pkey {:alg :es256})))

(defn fetch-token [{:keys [app-id installation-id pkey-file-path]}]
  (let [jwt     (gen-jwt app-id pkey-file-path)
        options {:auth (str "Authorization: Bearer " jwt)
                 :accept "Accept: application/vnd.github.v3+json"}]
    (api-call :get "app/installations/%s/access_tokens" [installation-id] options)))

(def CLI_CONFIG
  {:command     "ghapp-token-fetch"
   :runs        fetch-token
   :opts        [{:as     "App ID"
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
