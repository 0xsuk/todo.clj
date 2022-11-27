(ns todo.clj
  (:require [compojure.core :refer [routes]]
            [ring.adapter.jetty :as server]
            [ring.util.response :as res]
            [todo.handler.main :refer [main-routes]]
            [todo.handler.todo :refer [todo-routes]])
  (:gen-class))

(defonce server (atom nil))

(def app
  (routes
   todo-routes
   main-routes))

(defn start-server []
  (when-not @server
    (reset! server (server/run-jetty #'app {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (when @server
    (stop-server)
    (start-server)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
