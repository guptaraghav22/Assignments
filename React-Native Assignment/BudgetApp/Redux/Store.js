import { configureStore } from "@reduxjs/toolkit";
import persistReducerr from "./rootReducer";

const store = configureStore({
    reducer:persistReducerr
})

export default store;