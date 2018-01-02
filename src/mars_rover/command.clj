(ns mars-rover.command
	(:require [clojure.string :as string]
						[mars-rover.navigation :as nav]
						[mars-rover.rover :as rover]
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

(defn parse-navigate-command [input]
	(if (and (= 2 (count input)) (valid-number? (first input)) (valid-direction? (last input)))
		{:steps (Integer/parseInt (first input)) :direction (keyword (string/upper-case (last input))) :valid true :type :navigation}
		{:valid false}
	)
)

(defn parse-quit-command [command-string]
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

(defn print-status [] (println (format "The rover is now at %s" (rover/get-location))))

(defn move-rover-and-print-status [steps direction] 
  (rover/move steps direction)
  (print-status)
)

(defn quit-program []
	(println "Goodbye")
	(System/exit 0)
)

(defn execute [command]
	(case (get command :type)
		:quit (quit-program)
		:navigation (move-rover-and-print-status (get command :steps) (get command :direction))
	)
)