import { createStore, applyMiddleware } from "redux";
import rootReducer from "./reducers";
import { persistStore, persistReducer } from "redux-persist";

import thunk from "redux-thunk";
import storage from "redux-persist/lib/storage";
import { composeWithDevTools } from "redux-devtools-extension";

const middleware = [thunk];

const persistConfig = {
  key: "datalab",
  storage,
  whitelist: ["city", "country"],
};

const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = createStore(
  persistedReducer,
  composeWithDevTools(applyMiddleware(...middleware))
);

let persistor = persistStore(store);
export default { store, persistor };
