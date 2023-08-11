import { NavigationContainer } from "@react-navigation/native"
import { createNativeStackNavigator } from "@react-navigation/native-stack"
import Form from "../Form/Form"
import Show from "../ShowItem/ShowItem"
import { Provider } from "react-redux"
import Store from "../Redux/Store"
import persistStore from "redux-persist/es/persistStore"
import { PersistGate } from "redux-persist/integration/react"

let persiststore = persistStore(Store);

const Stack = createNativeStackNavigator()


const Navigation = ()=>
{
    return(
        <Provider store={Store}>
            <PersistGate persistor={persiststore}>
                
        <NavigationContainer>
            <Stack.Navigator>
            <Stack.Screen name="Form" component={Form}/>
            <Stack.Screen name="Show" component={Show}/>
            </Stack.Navigator>
        </NavigationContainer>
        </PersistGate>
        </Provider>
    )


}

export default Navigation;
