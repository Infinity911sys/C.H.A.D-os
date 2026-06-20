package com.austinenterprise.chadostk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.austinenterprise.chadostk.ui.theme.CHADosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CHADosTheme {
                CHADosApp()
            }
        }
    }
}

@Composable
fun CHADosApp() {
    var currentScreen by remember { mutableStateOf("home") }
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE8E8E8) // Platinum
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Navigation Bar
            TopAppBar(
                title = {
                    Text(
                        "C.H.A.D. OS",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D3436) // Charcoal
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00FF87) // Electric Green
                )
            )
            
            // Main Content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                when (currentScreen) {
                    "home" -> HomeScreen { currentScreen = it }
                    "ai-brain" -> AIBrainScreen()
                    "research" -> ResearchScreen()
                    else -> HomeScreen { currentScreen = it }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Welcome to C.H.A.D. OS",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D3436)
        )
        
        Text(
            "Conscious • Honest • Accountable • Disciplined",
            fontSize = 14.sp,
            color = Color(0xFF666666),
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Navigation Buttons
        Button(
            onClick = { onNavigate("ai-brain") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00FF87)
            ),
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        ) {
            Text("AI Brain", color = Color(0xFF2D3436), fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { onNavigate("research") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2D3436)
            ),
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        ) {
            Text("Research", color = Color(0xFF00FF87), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AIBrainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "AI Brain Module",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D3436)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Status: Active", fontWeight = FontWeight.Bold)
                Text("Processing: Enabled", modifier = Modifier.padding(top = 8.dp))
                Text("Learning Mode: On", modifier = Modifier.padding(top = 8.dp))
                Text("Knowledge Base: 1000+ entries", modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Composable
fun ResearchScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "C.H.A.D. Research Institute",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D3436)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            "Evidence-based behavioral systems framework",
            fontSize = 14.sp,
            color = Color(0xFF666666),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Research Categories:", fontWeight = FontWeight.Bold)
                Text("• Behavioral Systems Design", modifier = Modifier.padding(top = 8.dp))
                Text("• Trauma-Informed Legal Framework", modifier = Modifier.padding(top = 4.dp))
                Text("• Systemic Equity & Accountability", modifier = Modifier.padding(top = 4.dp))
                Text("• Evidence & Safety Records", modifier = Modifier.padding(top = 4.dp))
                Text("• C.H.A.D. OS Architecture", modifier = Modifier.padding(top = 4.dp))
                Text("• Personal Operating Systems", modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}
