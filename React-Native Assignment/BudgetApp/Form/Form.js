import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, TouchableOpacity } from 'react-native';
import { useDispatch } from 'react-redux';
import {save} from '../Redux/action'


const Form = (props) => {
  const [name, setName] = useState('');
  const [plannedAmount, setPlannedAmount] = useState('');
  const [actualAmount, setActualAmount] = useState('');

  const dispatch = useDispatch();

  const handleSubmit = () => {
    const item ={name,plannedAmount,actualAmount};
    // console.warn(item)
     dispatch(save(item))
    
  };

  const navigateToShow = () => {

    props.navigation.navigate('Show');


  };

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>Add-Expense</Text>
       
      <View style={styles.formContainer}>
        <TextInput
          style={styles.input}
          placeholder="Name"
          value={name}
          onChangeText={(text) => setName(text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Planned Amount"
          value={plannedAmount}
          onChangeText={(text) => setPlannedAmount(text)}
          keyboardType="numeric"
        />
        <TextInput
          style={styles.input}
          placeholder="Actual Amount"
          value={actualAmount}
          onChangeText={(text) => setActualAmount(text)}
          keyboardType="numeric"
        />
        <TouchableOpacity onPress={()=>handleSubmit()} color="#841584" >
        <Text style={styles.showItem} >Submit</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={navigateToShow} title="Show Items">
        <Text style={styles.showItem} >Show items</Text>
        </TouchableOpacity>
  </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5F5F5',
  },
  heading: {
    fontSize: 24,
    marginBottom: 24,
    color: '#841584',
  },
  formContainer: {
    width: '80%',
    backgroundColor: 'white',
    padding: 16,
    borderRadius: 8,
  },
  input: {
    width: '100%',
    height: 40,
    borderColor: '#DDDDDD',
    borderWidth: 1,
    marginBottom: 16,
    paddingHorizontal: 8,
    borderRadius: 4,
  },
  showItem: {
    color:'white',
    textAlign:'center',
    backgroundColor: '#841584',
    padding: 12,
    borderRadius: 4,
    alignItems: 'center',
    marginTop: 16,
  },
});

export default Form;