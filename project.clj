(defproject todo.clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.4.0"]
                 [compojure "1.4.0"]
                 [environ "1.0.1"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.5.1"]]
  :main ^:skip-aot todo.clj
  :target-path "target/%s"
  :plugins [[lein-environ "1.0.1"]]
  :profiles
  {:uberjar {:aot :all}
   :dev {:dependencies [[prone "0.8.2"]]
         :env {:dev true}}})
