(ns rich4clojure.easy.problem-083
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = A Half-Truth =
;; By 4Clojure user: cmeier
;; Difficulty: Easy
;; 
;; Write a function which takes a variable number of
;; booleans. Your function should return true if some of
;; the parameters are true, but not all of the parameters
;; are true. Otherwise your function should return false.

(def __ b)

(defn a [& bs]
  (= #{true false}
     (set bs)))

(defn b [& bs]
  (apply not= bs))

(comment
  (def bs [true false true])
  (apply a bs)
  (apply a bs)
  (a true false true)
  (a false true)
  (b true true true)
  (b true)
  (b true false true)
  (b false true)
  (= #{true false} #{true false})
  )

(tests
  false := (__ false false)
  true := (__ true false)
  false := (__ true)
  true := (__ false true false)
  false := (__ true true true)
  true := (__ true true true false))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/7fa7142a58af04b16b35d31ab00248a6