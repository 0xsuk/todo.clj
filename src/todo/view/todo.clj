(ns todo.view.todo
  (:require [hiccup.core :as hc]))

(defn todo-index-view [req todo-list]
  (-> `([:h1 "TODOs"]
        [:ul
         ~@(for [{:keys [title]} todo-list]
             [:li title])])
      hc/html))
