(ns validator.core
  ; (:use ring.middleware.json-params)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.adapter.jetty :as jetty]
            [compojure.handler :as handler]
            [rage-db.core :as rdb]
            [validator.cuatro :refer :all]
            [validator.offer-processor :refer :all]))

;; Utility function to parse an integer
(defn parse-number
  "Reads a number from a string. Returns nil if not a number."
  [s]
  (if (re-find #"^-?\d+\.?\d*$" s)
    (read-string s)))

(defroutes app-routes
  (POST "/example/api/initialize" request
    (prn "/example/api/initialize")
    (let [
          offer (get-in request [:json-params "offers"])
          rules (get-in request [:json-params "rules"])
          no_value (prn offer)
          no_value2 (prn rules)
          response (initialize-offers offer rules)]
      {:status 201 :body "success"}
    )
  )

  (POST "/example/api/process-sale" request
    (prn "/example/api/process-sale")
    (let [
          state (get-in request [:json-params "state"])
          sale (get-in request [:json-params "sale"])
          no_value (prn state)
          no_value2 (prn sale)
          response (process-sale state sale)]
      {:status 201 :body response}
    )
  )

  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-params)
      (middleware/wrap-json-response)
  )
)

(defn -main [& args]
  (jetty/run-jetty app)
)
