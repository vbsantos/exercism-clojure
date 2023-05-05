(ns log-levels
  (:require [clojure.string :as str]))

(defn- parse-log-line [s]
  (clojure.string/split s #"\]: "))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> s
      parse-log-line
      rest
      clojure.string/join
      clojure.string/trim))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (-> s
      parse-log-line
      first
      (subs 1)
      clojure.string/lower-case))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [message (message s) level (log-level s)]
    (str message " (" level ")")))
