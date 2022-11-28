(ns todo.db
  (:require [clojure.java.jdbc :as jdbc]))

; TODO hide credentials
(def db-spec
  {:dbtype "postgresql" :dbname "todo_clj_dev" :host "localhost" :port 5432 :user "postgres" :password "postgres"})

; TODO should be called before any operation
(defn migrate []
  (jdbc/db-do-commands
   db-spec
   (jdbc/create-table-ddl :todo [[:id :serial] [:title :varchar]])))
