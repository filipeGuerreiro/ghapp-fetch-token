(defproject ghapp-token-fetch "0.1.0"
  :description "A Clojure library designed to acquire an installation access token for your Github Apps."
  :url "https://github.com/filipeGuerreiro/ghapp-fetch-token"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :repositories [["clojars" {:url "https://clojars.org/repo"
                             :username [:env/clojars_username :gpg]
                             :password [:env/clojars_password :gpg]}]]
  :deploy-repositories  [["releases" :clojars]
                         ["snapshots" :clojars]]
  :signing {:gpg-key "868C4511"}
  :profiles {:dev {:global-vars {*warn-on-reflection* true}
                   :dependencies [[expectations "2.0.13"]]}}
  :main ghapp-token-fetch.core
  :aot [ghapp-token-fetch.core]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cli-matic "0.4.3"]
                 [irresponsible/tentacles "0.6.6"]
                 [buddy/buddy-sign "3.2.0"]
                 [clj-time "0.15.2"]]
  :plugins [[bansd/deploy-uberjar "0.1.2"]]
  :repl-options {:init-ns ghapp-token-fetch.core})
