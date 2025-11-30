import sys
import json
from textblob import TextBlob
from sklearn.linear_model import LinearRegression
import numpy as np

# === 1. The Machine Learning Model (Supervised Learning) ===
def predict_performance(cpa, attendance):
    # Training Data (Dummy historical data)
    # Features: [CPA, Attendance%]
    X = np.array([
        [2.0, 60], [2.5, 70], [3.0, 80], [3.5, 90], [4.0, 95], # Pass/Good
        [1.5, 50], [1.0, 40], [2.0, 30], [0.5, 20]             # Fail
    ])
    # Labels: 0 = Fail, 1 = Pass
    y = np.array([1, 1, 1, 1, 1, 0, 0, 0, 0])

    # Train the Logistic Regression Model
    model = LinearRegression()
    model.fit(X, y)

    # Predict for the new student
    prediction = model.predict([[cpa, attendance]])

    # Return result
    likelihood = prediction[0]
    if likelihood > 0.6:
        return f"PASS (Confidence: {likelihood:.2f})"
    else:
        return f"RISK OF FAILURE (Confidence: {likelihood:.2f})"

# === 2. NLP Sentiment Analysis ===
def analyze_sentiment(text):
    analysis = TextBlob(text)
    polarity = analysis.sentiment.polarity # -1 to +1

    if polarity > 0.3:
        return f"POSITIVE (Score: {polarity:.2f})"
    elif polarity < -0.3:
        return f"NEGATIVE (Score: {polarity:.2f})"
    else:
        return f"NEUTRAL (Score: {polarity:.2f})"

# === Main Entry Point ===
if __name__ == "__main__":
    # Java calls this script with arguments: python ai_engine.py [command] [args...]
    command = sys.argv[1]

    if command == "predict":
        cpa = float(sys.argv[2])
        attendance = int(sys.argv[3])
        print(predict_performance(cpa, attendance))

    elif command == "sentiment":
        # Join all remaining arguments to form the sentence
        text = " ".join(sys.argv[2:])
        print(analyze_sentiment(text))