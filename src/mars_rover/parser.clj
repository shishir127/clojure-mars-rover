(ns mars-rover.parser
	(:require [mars-rover.navigation :as nav]
			  [clojure.string :as string]
	)
)

(defn- valid-number? [number]
	(try
		(Integer/parseInt number)
		(catch Exception e false)
	)
)

(defn- valid-direction? [direction] 
	(contains? nav/directions (keyword (string/upper-case direction)))
)

(defn- parse-navigate-command [input]
	(if (and (= 2 (count input)) (valid-number? (first input)) (valid-direction? (last input)))
		{:steps (Integer/parseInt (first input)) :direction (keyword (string/upper-case (last input))) :valid true :type :navigation}
		{:valid false}
	)
)

(defn- parse-quit-command [command-string]
	(if (= "quit" (first command-string))
		{:valid true :type :quit}
		{:valid false}
	)
)

(defn parse [input-string]
	"Parses the input"
	(let [inputs (string/split input-string #" ")]
		(if (= 1 (count inputs))
			(parse-quit-command inputs)
			(parse-navigate-command inputs)
		)
	)
)
