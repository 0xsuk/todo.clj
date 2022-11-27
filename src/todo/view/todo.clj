(ns todo.view.todo
  (:require [todo.view.layout :as layout]))

(defn todo-index-view [req todo-list]
  (->> `([:h1 "TODOs"]
         [:ul
          ~@(for [{:keys [title]} todo-list]
              [:li title])])
       (layout/common req)))
