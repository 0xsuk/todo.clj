(ns todo.handler.main
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [todo.util.response :as res]))

(defn home-view [req]
  "<h1>Home</h1>
<a href=\"/todo\">TODOs</a>")

(defn home [req]
  (-> (home-view req)
      res/response
      res/html))

(defroutes main-routes
  (GET "/" _ home)
  (route/not-found "<h1>Not Found</h1>"))
