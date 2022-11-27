(ns todo.clj
  (:require [compojure.core :refer [routes]]
            [ring.adapter.jetty :as server]
            [todo.handler.main :refer [main-routes]]
            [todo.handler.todo :refer [todo-routes]]
            [todo.middleware :refer [wrap-dev]]
            [environ.core :refer [env]])
  (:gen-class))

(defonce server (atom nil))

(defn- wrap [handler middleware opt]
  (if (true? opt)
    (middleware handler)
    (if opt
      (middleware handler opt)
      handler)))

(def app
  (->
   (routes
    todo-routes
    main-routes)
   (wrap wrap-dev (:dev env))))

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
  (println "Todo.clj!")
  (start-server))
