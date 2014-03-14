# JavaScript evaluator library for Android

Library for evaluating JavaScript in Android apps. Supports Android version 3 and newer.

## Usage example

Create evaluator instance:

    JsEvaluator jsEvaluator = new JsEvaluator(this);

`this` is a reference to your activity.

Evaluate JavaScript and get result:

    jsEvaluator.evaluate("2 * 17", new JsCallback() {
      @Override
      public void onResult(final String result) {
        // get result here (optional)
      }
    });

Call a JS function:

    jsEvaluator.callFunction(new JsCallback() {
      @Override
      public void onResult(final String result) {
        // get result here
      }
    }, "functionName", "parameter 1", "parameter 2", 912, 101.3);

Any number of string, int or double parameters can be supplied.