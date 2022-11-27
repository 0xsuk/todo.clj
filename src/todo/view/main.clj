(ns todo.view.main
  (:require [todo.view.layout :as layout]))

(defn home-view [req]
  (->> [:section.card
        [:h2 "Home"]
        [:a {:href "/todo"} "TODOs"]]
       (layout/common req)))
