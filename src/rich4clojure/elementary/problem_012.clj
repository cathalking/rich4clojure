(ns rich4clojure.elementary.problem-012
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Intro to Sequences =
;; By 4Clojure user: dbyrne
;; Difficulty: Elementary
;; 
;; All Clojure collections support sequencing. You can
;; operate on sequences with functions like first, second,
;; and last.

(def __ :tests-will-fail)

(comment
  
  )

(tests
  3 := (first '(3 2 1))
  3 := (second [2 3 4])
  3 := (last (list 1 2 3)))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/f5d00ce2e066fb1487e3c4ffeb9b8848