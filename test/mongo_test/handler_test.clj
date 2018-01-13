(ns mongo_test.handler_test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [mongo_test.handler :refer :all]
            [midje.sweet :refer :all]
            [cheshire.core :refer :all]))

(fact "Test POST request to /agents returns expected response"
  (let [new_agent {:name "Bojack Horseman"
                   :primary_skillset ["bills-questions"]
                   :secondary_skillset []}
        response (app (-> (mock/request :post "/agent")
                          (mock/content-type "application/json")
                          (mock/body  (cheshire/generate-string ))))
        body     (parse-body (:body response))]
    (:status response) => 200)
    (:result body) => new_agent)))

(fact "Test GET request to /agents returns expected response"
  (let [new_agent {:name "Bojack Horseman"
                   :primary_skillset ["bills-questions"]
                   :secondary_skillset []}
        response (app (-> (mock/request :get "/agent")))
        body     (parse-body (:body response))]
    (:status response) => 200)
    (:result body) => new_agent))

(fact "Test POST request to /jobs returns expected response"
    (let [new_job {:type "Bills questions"
                 :urgent true}
        response (app (-> (mock/request :post "/job")
                          (mock/content-type "application/json")
                          (mock/body  (cheshire/generate-string ))))
        body     (parse-body (:body response))]
    (:status response) => 200
    (:result body) => new_agent)

(fact "Test GET request to /jobs returns expected response"
  (let [new_job {:type "Bills questions"
                 :urgent true}
        response (app (-> (mock/request :get "/job")))
        body     (parse-body (:body response))]
    (:status response) => 200
    (:result body) => new_job))              

(fact "Test GET request to /assigned-jobs/{:id_agent} returns expected response"
  (let [job_assigned {:job_id id
                      :agent_id id}
        response (app (-> (mock/request :get "/job")))
        body     (parse-body (:body response))]
    (:status response) => 200
    (:result body) => job_assigned)) 
