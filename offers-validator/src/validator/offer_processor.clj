(ns validator.offer-processor
  (require [validator.offer_applier :refer :all]
           [validator.convertions :refer :all]
           [validator.insertions :refer :all]
  )
)

(defn initialize-offers [offers rules]
  (do
    (add_rule rules) (add_offer offers)
    (prn "initialize-offers created")
  )
  "created"
)

(defn process-sale [state sale]
  (map_to_json
    (vec
      (apply concat
        (for
          [
            o offers_vector
            :let
            [
              no_value (pass_rules rules_vector)
              result (apply_offer o sale)
              no_value (prn "process-sale")
            ]
          ]
          result
        )
      )
    )
  )
)
