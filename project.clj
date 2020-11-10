(defproject ghapp-token-fetch "0.1.1"
  :description "A Clojure library designed to acquire an installation access token for your Github Apps."
  :url "https://github.com/filipeGuerreiro/ghapp-fetch-token"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases false}]]
  :main ghapp-token-fetch.core
  :aot [ghapp-token-fetch.core]
  :omit-source true
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cli-matic "0.4.3"]
                 [irresponsible/tentacles "0.6.6"]
                 [buddy/buddy-sign "3.2.0"]
                 [clj-time "0.15.2"]]
  :plugins [[bansd/deploy-uberjar "0.1.2"]]
  :repl-options {:init-ns ghapp-token-fetch.core})
