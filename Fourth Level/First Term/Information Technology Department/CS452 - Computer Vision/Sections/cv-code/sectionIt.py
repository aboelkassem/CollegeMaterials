import cv2 
import numpy as np 

img = cv2.imread('./new.jpg' , 0)
imgNew = cv2.imread('./apple.jpg' , 0)

orb = cv2.ORB_create()

keyPointsOriginal , dectriptorOriginal = orb.detectAndCompute(img , None)
keyPointsNew , dectriptorNew = orb.detectAndCompute(imgNew , None)

bf = cv2.BFMatcher(cv2.NORM_HAMMING , crossCheck=True )

matches = bf.match(dectriptorOriginal , dectriptorNew)

matchingResult = cv2.drawMatches(img , keyPointsOriginal ,imgNew ,keyPointsNew , matches[:20] , None  )

cv2.imshow('matching result ' ,matchingResult )

cv2.waitKey(0)
cv2.destroyAllWindows()
