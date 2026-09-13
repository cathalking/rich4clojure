(ns rich4clojure.elementary.problem-156
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Map Defaults =
;; By 4Clojure user: jaycfields
;; Difficulty: Elementary
;; Tags: [seqs]
;; 
;; When retrieving values from a map, you can specify
;; default values in case the key is not found:
;; 
;; 
;; (= 2 (:foo {:bar 0, :baz 1} 2))
;; 
;; 
;; However, what if you want the map itself to contain
;; the default values? Write a function which takes a
;; default value and a sequence of keys and constructs a
;; map.

(def __ ;:tests-will-fail
  (fn [v ks]
    (loop [m {} 
           ks ks]
      (if (empty? ks)
          m
          (recur (conj m [(first ks) v]) (rest ks)))))
  )

(comment
  (conj {:d 0}
        [:a 0]
        [:b 0]
        [:c 0])
  (loop [m {} ks [:a :b :c] v 0]
    (if (empty? ks)
      m
      (recur (conj m [(first ks) v]) (rest ks) v)))
  )

(tests
  (__ 0 [:a :b :c]) := {:a 0 :b 0 :c 0}
  (__ "x" [1 2 3]) := {1 "x" 2 "x" 3 "x"}
  (__ [:a :b] [:foo :bar]) := {:foo [:a :b] :bar [:a :b]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4e79a8389a4687b2564262b46785d45a