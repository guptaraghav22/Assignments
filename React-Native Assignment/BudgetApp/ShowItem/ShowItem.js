import React from 'react';
import { useSelector } from 'react-redux';
import { View, Text, FlatList, StyleSheet } from 'react-native';

const Show = () => {
  const data = useSelector((state) => state.reducer);
  console.warn(data);

  const Card = ({ item }) => {
    return (
      <View style={styles.card}>
        <Text style={styles.title}>Expense Name: {item.name}</Text>
        <Text style={styles.description}>Planned Amount: {item.plannedAmount}</Text>
        <Text style={styles.description}>Actual Amount: {item.actualAmount}</Text>
      </View>
    );
  };

  return (
    <View style={styles.container}>
      {data.map((item) => (
        <Card key={item.id} item={item} />
      ))}
    </View> 
     );
};

const styles = StyleSheet.create({
    container: {
      flex: 1,
      padding: 16,
      backgroundColor: '#F5F5F5',
    },
    card: {
      backgroundColor: 'white',
      borderRadius: 8,
      padding: 16,
      marginBottom: 16,
      elevation: 2,
      shadowColor: '#000',
      shadowOpacity: 0.2,
      shadowOffset: { width: 0, height: 2 },
      shadowRadius: 4,
    },
    title: {
      fontSize: 18,
      fontWeight: 'bold',
      marginBottom: 8,
    },
    description: {
      fontSize: 16,
    },
  });

export default Show;
