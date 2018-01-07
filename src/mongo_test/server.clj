(ns mongo_test.server
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

(let [uri "mongodb://mariliamj:314159@ds245347.mlab.com:45347/jobqueue"
      {:keys [conn db]} (mg/connect-via-uri uri)])
