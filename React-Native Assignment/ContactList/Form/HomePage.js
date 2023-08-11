import { View,Text,StyleSheet,TouchableOpacity } from "react-native"
import { useNavigation } from '@react-navigation/native';
import {openDatabase} from 'react-native-sqlite-storage'
import {useEffect} from 'react'

let db = openDatabase({name:'ContactInfo.db'})


let Homepage = ()=>{
    const navigation = useNavigation();
    return(
        <View style={styles.container}>
      {/* Your screen content here */}
      <TouchableOpacity onPress={() => navigation.navigate('AddContact')} style={styles.addButton}>
        <Text style={styles.buttonText}>Add</Text>
      </TouchableOpacity>
    </View>
    )

      
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
    },
    addButton: {
      position: 'absolute',
      bottom: 20,
      right: 20,
      backgroundColor: 'blue',
      borderRadius: 30,
      padding: 15,
    },
    buttonText: {
      color: 'white',
      fontSize: 16,
    },
  });

export default Homepage