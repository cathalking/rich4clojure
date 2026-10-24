(ns rich4clojure.easy.problem-063
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Group a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [core-functions]
;; 
;; Given a function f and a sequence s, write a function
;; which returns a map. The keys should be the values of f
;; applied to each item in s. The value at each key should
;; be a vector of corresponding items in the order they
;; appear in s.

(def restricted [group-by])

(def __ b)

(defn a [f s]
  (let [ms (map (fn [x] {(f x) [x]}) s)]
    (reduce 
     (fn [acc x] (merge-with into acc x)) 
     {} ms)))
    
(defn b [f s]
  (let [kvs (map (fn [x] [(f x) x]) s)]
    (reduce 
     ;;(fn [acc [k v]] (update acc k conj v)) 
     (fn [acc [k v]] (update acc k (fnil conj []) v)) 
     {} kvs)))

(comment
  (let [f even?
        s [0 1 2 3 4]
        ms (map (fn [x] {(f x) [x]}) s)]
    (reduce (fn [acc x] (merge-with into acc x)) {} ms))
  ;;=> {true [0 2 4], false [1 3]}
  (let [f even?
        s [0 1 2 3 4]
        ms (map (fn [x] {(f x) x}) s)]
    ;; ms
    ;;=> ({true 0} {false 1} {true 2} {false 3} {true 4})
    (reduce (fn [acc [k v]] (merge-with into acc {k [v]})) {} ms))
  ;;=> ({true [0]} {false [1]} {true [2]} {false [3]} {true [4]})
  (first {:a 1})

  (merge-with into {} {true})
  (a even? [0 1 2 3 4])
  (b even? [0 1 2 3 4])
  ;;=> ({true [0]} {false [1]} {true [2]} {false [3]} {true [4]})
  (into {:a [1]} {:a [2]})
  ;;=> {:a [2]}
  (into [1] [2])
  ;;=> [1 2]
  (conj [1] [2])
  ;;=> [1 [2]]
  (concat [1] [2])
  ;;=> (1 2)
  (vec (concat [1] [2]))
  ;;=> [1 2]
  ((comp vec concat) [1] [2])
  ;;=> [1 2]
  (merge-with
   into {:a [1]} {:a [2]})
  (merge-with
   concat {:a [1]} {:a [2]})
  (update {} true conj 1)
  ;;=> {true (1)}
  (conj nil 1)
  ;;=> (1)
  (update {} true (fnil conj []) 1)
  ;;=> {true [1]}
  )
  ;;=> {:a [1 2]}
  


(tests
 (__ #(> % 5) [1 3 6 8]) := {false [1 3], true [6 8]}
 (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) :=
 {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}
 (__ count [[1] [1 2] [3] [1 2 3] [2 3]]) :=
 {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b49b9b1171a0d8340f94893a614a43ec