(ns organizer.example.instaparse-org-test
  (:require [organizer.example.instaparse-org :refer :all]
            [clojure.test :refer :all]))


(def org-test-string
  "* Hallo\n**    Welt\n***Foo
**** Bar")

(deftest org-heading-parser-test
  (is (= (org-parse-string org-test-string)
         [:org
          [:heading [:stars "*"] [:title "Hallo"]]
          [:heading [:stars "**"] [:title "Welt"]]
          [:heading [:stars "***"] [:title "Foo"]]
          [:heading [:stars "****"] [:title "Bar"]]])))

(deftest org-level-test
  (is (= (org-analyze-level (org-parse-string org-test-string))
         [:org
          [:heading 1 [:title "Hallo"]]
          [:heading 2 [:title "Welt"]]
          [:heading 3 [:title "Foo"]]
          [:heading 4 [:title "Bar"]]])))
