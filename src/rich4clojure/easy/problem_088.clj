(ns rich4clojure.easy.problem-088
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.set :refer [union select intersection difference]]))

;; = Symmetric Difference =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [set-theory]
;; 
;; Write a function which returns the symmetric difference
;; of two sets. The symmetric difference is the set of
;; items belonging to one but not both of the two sets.

(def __ a)

(defn a [s1 s2]
  (set (filter #(not= (s1 %) (s2 %)) (concat s1 s2)))) 

(defn b [s1 s2]
  (select #(not= (s1 %) (s2 %)) (union s1 s2))) 

(defn c [s1 s2]
  (apply disj (union s1 s2) (filter s1 s2)))

(defn d [s1 s2]
  (difference (union s1 s2) (intersection s1 s2)))

(comment
  (def s1 #{1 2 3 4 5 6}) 
  (def s2 #{1 3 5 7})
  (def u
    (union s1 s2))
  
  (apply disj u (filter s1 s2))
  (filter (fn [x] (let [c1 (s1 x)
                        c2 (s2 x)]
                    (not= c1 c2))) u)
  (select #(not= (s1 %) (s2 %)) u) 
  (filter s1 s2)
  ;;=> (1 3 5)
  (intersection s1 s2)
  ;;=> #{1 3 5}

  (a s1 s2)
  (b s1 s2)
  (c s1 s2)
  (d s1 s2)

  )

(tests
  (__ #{1 2 3 4 5 6} #{1 3 5 7}) := #{2 4 6 7}
  (__ #{:a :b :c} #{}) := #{:a :b :c}
  (__ #{} #{4 5 6}) := #{4 5 6}
  (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) := #{[1 2] [3 4]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b78bc7de41bb6cef6ca18c1e924bb5ac