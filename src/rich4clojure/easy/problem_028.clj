(ns rich4clojure.easy.problem-028
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Flatten a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which flattens a sequence.

(def restricted [flatten])


(comment
  (sequential? ["a" "b"])
  ((complement empty?) ["a"]))
  
(defn x_ [s] 
  (loop [s s
         acc []]
    (if (empty? s)
      (reverse acc)
      (let [f (first s)]
        (if (sequential? f)
          (recur f acc)
          (recur (rest s) (cons f acc)))))))
(defn x [s]
  (loop [f (first s)
         r (rest s)
         acc []]
    (if (and (nil? f) (empty? r))
      (reverse acc)
      (if (sequential? f)
        (recur f r acc)
        (recur (first r) (rest r) (cons f acc))))))

(defn first-non-seq-elem [s]
  (loop [f (first s)
        r (rest s)]
    (if (not (sequential? f))
      f
      (recur (first f) r))))
(first-non-seq-elem '(1))
(first-non-seq-elem '((1)))
(first-non-seq-elem [[[[[[1]]]]] 2])

(defn b [s]
  (loop [f   (first s)
         r   (rest s)
         acc []]
    (cond
      (and (empty? r) (and (sequential? f) (empty? f))) (reverse (cons f acc))
      (and (sequential? f) (empty? f)) (recur (first r) (rest r) acc)
      (sequential? f) (recur (first f) (cons (rest f) r) acc)
      :else (recur (first r) (rest r) (cons f acc)))))
(b '((1 2) 3 4))
(b '((1 2) 2 3))
(b '((1 2) 3 [4 [5 6]]))
(cons (rest '(1 2)) '(2 3))
(x '(1 2 3))
(x '(1 2 [3] 4))
(seq [1 3])
    
(apply vector [1 2])
(cons 1 [1 2])
  
(defn c [s]
  (loop [f   (first s)
         n   (next s)
         acc []]
    (cond
      (and (nil? n) (nil? f)) (reverse acc)
      (nil? f) (recur (first n) (next n) acc)
      (sequential? f) (recur (first f) (cons (next f) n) acc)
      :else (recur (first n) (next n) (cons f acc)))))
(defn d [s]
  (loop [f   (first s)
         n   (next s)
         acc []]
    (if 
     (sequential? f) (recur (first f) 
                            (if-let [f (next f)] 
                              (cons f n) 
                              n) 
                            acc)
     (cond
       (and (nil? n) (nil? f)) (reverse acc)
       :else (recur (first n) 
                    (next n) 
                    (if (nil? f) 
                      acc 
                      (cons f acc)))))))

(defn e [s]
  (loop [f   (first s)
         n   (next s)
         acc []]
    (if 
     (sequential? f) (recur (first f) 
                            (if-let [f (next f)] 
                              (cons f n) 
                              n) 
                            acc)
     (if (nil? n) 
       (reverse (cons f acc))
       (recur (first n) 
                    (next n) 
                    (if (nil? f) 
                      acc 
                      (cons f acc)))))))
(def f (fn flat [coll]
         (if (coll? coll)
           (mapcat flat coll)
           [coll])) )
(def __ f)

(__ '((1 2) 3 4))
(__ '((1 2) 3 [4 [5 6]]))
(__ ["a" ["b"] "c"])
(__ '((((:a)))))

(tests
 (__ '((1 2) 3 [4 [5 6]])) := '(1 2 3 4 5 6)
 (__ ["a" ["b"] "c"]) := '("a" "b" "c")
 (__ '((((:a))))) := '(:a))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/0c6e3c48cac7434882ca4b2c71ebfce1