(ns todo.handler.main
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [todo.util.response :as res]
            [todo.view.main :as view]))

(defn home [req]
  (-> (view/home-view req)
      res/response
      res/html))

(defroutes main-routes
  (GET "/" _ home)
  (route/not-found "<h1>Not Found</h1>"))
