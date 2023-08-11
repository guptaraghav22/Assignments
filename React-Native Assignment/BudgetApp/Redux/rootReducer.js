import { combineReducers } from "redux";
import {reducer} from './Reducer'

import { persistReducer } from "redux-persist";
import  storage  from "redux-persist/lib/storage";
import AsyncStorage from "@react-native-async-storage/async-storage";
let persistConfig={
    key:'root',
    storage:AsyncStorage
}


let rootReducer =  combineReducers({
    reducer:reducer
})
let persistReducerr = persistReducer(persistConfig,rootReducer)


export default persistReducerr;
