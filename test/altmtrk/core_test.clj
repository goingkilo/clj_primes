(ns altmtrk.core-test
  (:require [clojure.test :refer :all]
            [altmtrk.core :refer :all]))

(deftest test-is-prime-2
  (testing " Check if is-prime-2 can identify primes."
        (is (= (is-prime-2 0) :undefined))
        (is (= (is-prime-2 1) :undefined))
        (is (is-prime-2 2)  )
        (is (is-prime-2 3)  )
        (is (is-prime-2 5)  )
        (is (is-prime-2 7)  )
        (is (not (is-prime-2 4)))
        (is (not (is-prime-2 6)))))


(deftest test-is-prime
  (testing " Check if is-prime-1 can identify primes."
        (is (= (is-prime-1 0) :undefined))
        (is (= (is-prime-1 1) :undefined))
        (is (is-prime-1 2))
        (is (is-prime-1 3))
        (is (is-prime-1 5))
        (is (is-prime-1 7) )
        (is  (not (is-prime-1 4)))
        (is (not (is-prime-1 6)))))

(deftest test-gen
    (testing "Check if gen-sequence returns n correct items"
        (let [ generated-list (gen-sequence 1 10 #(zero? (rem % 2)) []) ]
            (is (= (count generated-list) 10))
            (is ( = generated-list [2 4 6 8 10 12 14 16 18 20])))))