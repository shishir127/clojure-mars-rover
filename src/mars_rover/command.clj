(ns mars-rover.command
	(:require [clojure.string :as string]
						[mars-rover.navigation :as nav]
	)
)

(defn valid-number? [number]
	(try
		(Integer/parseInt number)
		(catch Exception e false)
	)
)

(defn valid-direction? [direction] 
	(contains? nav/directions (keyword (string/upper-case direction)))
)

(defn parse [input-string]
	"Parses the input"
	(let [inputs (string/split input-string #" ")]
		(if (and (= 2 (count inputs)) (valid-number? (first inputs)) (valid-direction? (last inputs)))
			{:steps (Integer/parseInt (first inputs)) :direction (keyword (string/upper-case (last inputs))) :valid true}
			{:valid false}
		)
	)
)
