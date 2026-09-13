(ns rich4clojure.elementary.problem-015
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Double Down =
;; By 4Clojure user: dbyrne
;; Difficulty: Elementary
;; 
;; Write a function which doubles a number.

(def __ :tests-will-fail)

(comment
  
  )

(tests
 ((fn doubler [x] (* x 2)) 2) := 4
 ((fn [x] (* x 2)) 3) := 6
 (#(* % 2) 11) := 22
 ((partial * 2) 7) := 14)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b00355c5b51c4e29e27a09b6ed2f7a73