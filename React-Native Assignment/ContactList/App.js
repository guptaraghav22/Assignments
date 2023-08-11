import Homepage from "./Form/HomePage";
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import AddContact from "./Add-Contact/addContact";
function App(){

  const Stack = createNativeStackNavigator();

  return(
    <NavigationContainer>
    <Stack.Navigator>
      <Stack.Screen name="Home" component={Homepage} />
      <Stack.Screen name="AddContact" component={AddContact} />
    </Stack.Navigator>
  </NavigationContainer>
  )
}


export default App;
