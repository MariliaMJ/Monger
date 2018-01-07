(ns mongo_test.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))

;; localhost, default port
(let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")]
  ;; with a generated document id, returns the complete
  ;; inserted document
  (mc/insert-and-return db "documents" {:name "John" :age 30})