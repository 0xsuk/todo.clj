(ns todo.view.todo
  (:require [todo.view.layout :as layout]
            [hiccup.form :as hf]))

(defn todo-index-view [req todo-list]
  (->> [:section.card
        [:h2 "TODOs"]
        [:a {:href (str "/todo/new")} "add new"]
        [:ul
         (for [{:keys [id title]} todo-list]
           [:li [:a {:href (str "/todo/" id)} title]])]]
       (layout/common req)))

(defn todo-new-view [req]
  (->> [:section.card
        [:h2 "add Todo"]
        (hf/form-to
         [:post "/todo/new"]
         [:input {:name :title :placeholder "enter todo"}]
         [:button.bg-blue "add"])]
       (layout/common req)))

(defn todo-show-view [req todo]
  (let [todo-id (:id todo)]
    (->> [:section.card
          [:h2 (:title todo)]
          [:a.wide-link {:href (str "/todo/" todo-id "/delete")} "delete"]]
         (layout/common req))))

(defn todo-delete-view [req todo]
  (println todo)
  (let [todo-id (get-in req [:params :todo-id])]
    (->> [:section.card
          [:h2 "TODO delete"]
          (hf/form-to
           [:post (str "/todo/" todo-id "/delete")]
           [:p "*" (:title todo)]
           [:button.bg-red "delete"])]
         (layout/common req))))
