(defproject ghapp-token-fetch "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main ghapp-token-fetch.core
  :aot [ghapp-token-fetch.core]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cli-matic "0.4.3"]
                 [irresponsible/tentacles "0.6.6"]
                 [buddy/buddy-sign "3.2.0"]
                 [clj-time "0.15.2"]]
  :repl-options {:init-ns ghapp-token-fetch.core})
