import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native';
import {openDatabase} from 'react-native-sqlite-storage'
import {useEffect} from 'react'


let db  = openDatabase({name: 'ContactInfo.db'});




const AddContact = () => {
  const [name, setName] = useState('');
  const [mobile, setMobile] = useState('');
  const [landline, setLandline] = useState('');
  const [photo, setPhoto] = useState('');

  

  const handleFormSubmit = () => {
    // Perform form submission logic here
    console.warn('Form submitted!');
    console.warn('Name:', name);
    console.warn('Mobile:', mobile);
    console.warn('Landline:', landline);
    console.warn('Photo:', photo);
  };

  useEffect(() => {
    db.transaction( txn=> {
      txn.executeSql(
        "SELECT name FROM sqlite_master WHERE type='table' AND name='table_user'",
        [],
        (tx, res)=> {
          console.log('item:', res.rows.length);
          if (res.rows.length == 0) {
            txn.executeSql('DROP TABLE IF EXISTS table_user', []);
            txn.executeSql(
              'CREATE TABLE IF NOT EXISTS table_user(Name INTEGER PRIMARY KEY,Mobile VARCHAR(20), Landline VARCHAR(20), imageAddress VARCHAR(255))',
              []
            );
          }
          else{
            console.log("account already created")
          }
        }
      );
    });
  }, []);

  const savedata=()=>{
    db.transaction
    ( txn=> {
    txn.executeSql('INSERT INTO table_user(Name,Mobile,Landline,imageAddress) VALUES (?,?,?)',[name,mobile,landline,photo],
    (tex,res)=>{
        console.log(res)
    }
    )
        }
    )}
    
  return (
    <View style={styles.container}>
      <Text style={styles.label}>Name:</Text>
      <TextInput
        style={styles.input}
        value={name}
        onChangeText={setName}
        placeholder="Enter name"
      />

      <Text style={styles.label}>Mobile:</Text>
      <TextInput
        style={styles.input}
        value={mobile}
        onChangeText={setMobile}
        placeholder="Enter mobile number"
        keyboardType="phone-pad"
      />

      <Text style={styles.label}>Landline:</Text>
      <TextInput
        style={styles.input}
        value={landline}
        onChangeText={setLandline}
        placeholder="Enter landline number"
        keyboardType="phone-pad"
      />

      <Text style={styles.label}>Photo:</Text>
      <TextInput
        style={styles.input}
        value={photo}
        onChangeText={setPhoto}
        placeholder="Enter photo URL"
      />

      {/* <TouchableOpacity style={styles.button} onPress={handleFormSubmit}> */}
      <TouchableOpacity style={styles.button} onPress={savedata()}>
        <Text style={styles.buttonText}>Submit</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  label: {
    fontSize: 16,
    marginBottom: 5,
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 15,
    paddingHorizontal: 10,
  },
  button: {
    backgroundColor: 'blue',
    borderRadius: 5,
    padding: 10,
    alignItems: 'center',
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
  },
});

export default AddContact;