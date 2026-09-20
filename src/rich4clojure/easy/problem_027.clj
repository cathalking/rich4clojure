(ns rich4clojure.easy.problem-027
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.math :refer [floor]]))

;; = Palindrome Detector =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which returns true if the given
;; sequence is a palindrome.
;; 
;; 
;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

(def __1
  (fn [i]
    (let [s (seq i)
          len (count s)
          rlen (rem len 2)
          s1-end (/ (- len rlen) 2)
          s2-beg (/ (+ len rlen) 2)
          s1 (take s1-end s)
          s2 (nthrest s s2-beg)
          s2-rev (reverse s2)]
      (= s1 s2-rev))))

(def __2 #(= (seq %) (reverse %)))

(def __ #(loop [coll %]
           (cond 
             (empty? coll) true
             (not= (first coll) (last coll)) false
             :else (recur (butlast (rest coll))))))
      
(seq "abc")
(seq '(1 2 3 2 1))
(__ "aba")

(comment)

(tests
  (__ '(1 2 3 4 5)) := false
  (__ "racecar") := true
  (__ [:foo :bar :foo]) := true
  (__ '(1 1 3 3 1 1)) := true
  (__ '(:a :b :c)) := false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/a9620760aad9da40c497f5750087a095
