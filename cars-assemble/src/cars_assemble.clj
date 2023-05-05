(ns cars-assemble)

(defn success-rate
  "Calculates the success rate of the assembly line based on the given speed.

  Args:
  - speed: The speed of the assembly line, in cars per hour.

  Returns:
  The success rate of the assembly line."
  [speed]
  (cond
    (= speed 0) 0
    (< speed 5) 1
    (< speed 9) 0.9
    (< speed 10) 0.8
    :else 0.77))

(defn production-rate
  "Calculates the assembly line's production rate per hour,
   taking into account its success rate.

   Args:
   - speed: The speed of the assembly line, in cars per hour.

   Returns:
   The assembly line's production rate per hour, in cars per hour."
  [speed]
  (let [success-rate (success-rate speed) production-rate (* speed 221.0)]
    (* production-rate success-rate)))

(defn working-items
  "Calculates the number of working cars that can be produced per minute by the assembly line.

  Args:
  - speed: The speed of the assembly line, in cars per hour.

  Returns:
  The number of working cars that can be produced per minute."
  [speed]
  (let [production-rate-per-minute (/ (production-rate speed) 60)]
    (int production-rate-per-minute)))
