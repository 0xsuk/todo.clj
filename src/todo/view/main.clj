(ns todo.view.main
  (:require [hiccup.core :as hc]))

(defn home-view [req]
  (-> (list
       [:h1 "Home"]
       [:a {:href "/todo"} "TODOs"])
      hc/html))
