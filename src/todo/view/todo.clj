(ns todo.view.todo
  (:require [todo.view.layout :as layout]
            [hiccup.form :as hf]))

(defn todo-index-view [req todo-list]
  (->> `([:h1 "TODOs"]
         [:ul
          ~@(for [{:keys [title]} todo-list]
              [:li title])])
       (layout/common req)))

(defn todo-new-view [req]
  (->> [:section.card
        [:h2 "add Todo"]
        (hf/form-to
         [:post "/todo/new"]
         [:input {:name :title :placeholder "enter todo"}]
         [:button.bg-blue "add"])]
       (layout/common req)))

(defn todo-complete-view [req]
  (->> [:section.card
        [:h2 "added Todo"]]
       (layout/common req)))
