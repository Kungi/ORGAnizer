(ns organizer.example.instaparse-org-test
  (:require [organizer.example.instaparse-org :refer :all]
            [clojure.test :refer :all]))


(deftest org-parser-test
  (is (= (org-parse-string "* Hallo")
         [:org [:heading
                [:stars "*"]
                [:title "Hallo"]]]))
  
  (is (= (org-parse-string "* Welt")
         [:org [:heading
                [:stars "*"]
                [:title "Welt"]]]))

  (is (= (org-parse-string "*      Welt")
         [:org [:heading
                [:stars "*"]
                [:title "Welt"]]]))

  (is (= (org-parse-string "**** Welt")
         [:org [:heading
                [:stars "****"]
                [:title "Welt"]]]))

  (is (= (org-parse-string "* Hallo\n**Welt\n")
         [:org
          [:heading [:stars "*"] [:title "Hallo"]]
          [:heading [:stars "**"] [:title "Welt"]]]))

  (is (= (org-parse-string
          "* Hallo
*Welt\n")
         [:org
          [:heading [:stars "*"] [:title "Hallo"]]
          [:heading [:stars "*"] [:title "Welt"]]])))
