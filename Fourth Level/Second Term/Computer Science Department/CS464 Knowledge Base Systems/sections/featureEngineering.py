import pandas
import textblob

# In case you have a problem reading your dataset , check its encoding

# import chardet
# with open("McDonalds-Yelp-Sentiment-DFE.csv", 'rb') as rawdata:
#     result = chardet.detect(rawdata.read(100000))
# print(result)
# dataset = pandas.read_csv("McDonalds-Yelp-Sentiment-DFE.csv",encoding="Windows-1252")

# Reading and Summarizing Text Data
from textblob import TextBlob

dataset = pandas.read_csv("amazon_alexa.tsv", delimiter="\t")
# print(type(dataset))
# print(dataset.shape)
# print(dataset.tail())
# print(dataset.isnull().sum())
# print(dataset.describe())
# print(dataset.describe(include="object"))
# print(dataset["verified_reviews"].value_counts())

# Length, Polarity and Subjectivity

dataset["length"] = dataset["verified_reviews"].apply(len)
# print(dataset["length"])
#
#
#
# def get_polarity(text):
#     textblob = TextBlob(str(text.encode("utf-8")))
#     pol = textblob.sentiment.polarity
#     return pol
#
# def get_subjectivity(text):
#     textblob = TextBlob(str(text.encode("utf-8")))
#     pol = textblob.sentiment.subjectivity
#     return pol
#
#
# dataset["Polarity"] = dataset["verified_reviews"].apply(get_polarity)
# dataset["Subjectivity"] = dataset["verified_reviews"].apply(get_subjectivity)
#
# print(dataset[['length', 'Polarity', 'Subjectivity']].describe())

# Words , Characters and punctuation

dataset["charsCount"] = dataset["verified_reviews"].apply(len)
dataset["wordCount"] = dataset["verified_reviews"].apply(lambda x: len(x.split()))
dataset["word_density"] = dataset["charsCount"] / (dataset["wordCount"]+1)
print(dataset[['charsCount', 'wordCount', 'word_density']].describe())

# Nouns , Verbs , pronoun , Adverbs , Adj

